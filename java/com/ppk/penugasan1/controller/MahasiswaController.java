/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ppk.penugasan1.controller;

import com.ppk.penugasan1.dto.MahasiswaDTO;
import com.ppk.penugasan1.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
/**
 *
 * @author seizr
 */
@Controller
public class MahasiswaController {
    private final MahasiswaService mahasiswaService;

    @Autowired
    public MahasiswaController(MahasiswaService mahasiswaService) {
        this.mahasiswaService = mahasiswaService;
    }
    
    @GetMapping("/")
    public String viewDashboardUser(ModelMap model) {
        return "dashboard";
    }

    @GetMapping("/list-mahasiswa")
    public String viewListMahasiswa(Model model) {
        List<MahasiswaDTO> mahasiswaList = mahasiswaService.ambilData();
        model.addAttribute("mahasiswaList", mahasiswaList);
        return "list-mahasiswa";
    }

    @GetMapping("/tambah-mahasiswa")
    public String viewFormTambahMahasiswa(Model model) {
        model.addAttribute("mahasiswa", new MahasiswaDTO());
        return "tambah-mahasiswa";
    }

    @PostMapping("/tambah-mahasiswa/submit")
    public String submitFormTambahMahasiswa(@ModelAttribute MahasiswaDTO mahasiswaDTO) {
        mahasiswaService.simpanData(mahasiswaDTO);
        return "redirect:/list-mahasiswa";
    }

    @GetMapping("/mahasiswa/delete/{nim}")
    public String hapusMahasiswa(@PathVariable String nim) {
        mahasiswaService.hapusDataByNIM(nim);
        return "redirect:/list-mahasiswa";
    }

    @GetMapping("/mahasiswa/edit/{nim}")
    public String viewFormEditMahasiswa(@PathVariable String nim, Model model) {
        MahasiswaDTO mahasiswaDTO = mahasiswaService.ambilDataByNIM(nim);
        model.addAttribute("mahasiswa", mahasiswaDTO);
        return "edit-mahasiswa";
    }

    @PostMapping("/mahasiswa/edit/submit")
    public String submitFormEditMahasiswa(@ModelAttribute MahasiswaDTO updatedMahasiswaDTO) {
        mahasiswaService.perbaruiDataByNIM(updatedMahasiswaDTO.getNim(), updatedMahasiswaDTO);
        return "redirect:/list-mahasiswa";
    }

    @GetMapping("/mahasiswa/view/{nim}")
    public String viewDetailMahasiswa(@PathVariable String nim, Model model) {
        MahasiswaDTO mahasiswaDTO = mahasiswaService.ambilDataByNIM(nim);
        model.addAttribute("mahasiswa", mahasiswaDTO);
        return "view-mahasiswa";
    }

    @GetMapping("/search-mahasiswa")
    public String searchMahasiswa(
            @RequestParam("searchBy") String searchBy,
            @RequestParam(value = "nim", required = false) String nim,
            @RequestParam(value = "nama", required = false) String nama,
            Model model
    ) {
        if ("nim".equalsIgnoreCase(searchBy)) {
            MahasiswaDTO mahasiswaDTO = mahasiswaService.ambilDataByNIM(nim);
            if (mahasiswaDTO != null) {
                model.addAttribute("mahasiswaList", Collections.singletonList(mahasiswaDTO));
            } else {
                model.addAttribute("mahasiswaList", Collections.emptyList());
            }
        } else if ("nama".equalsIgnoreCase(searchBy)) {
            List<MahasiswaDTO> mahasiswaList = mahasiswaService.ambilDataByNama(nama);
            model.addAttribute("mahasiswaList", mahasiswaList);
        }
        return "list-mahasiswa";
    }
}
