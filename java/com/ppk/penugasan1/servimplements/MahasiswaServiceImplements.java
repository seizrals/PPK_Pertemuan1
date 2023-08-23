/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ppk.penugasan1.servimplements;

import com.ppk.penugasan1.dto.MahasiswaDTO;
import com.ppk.penugasan1.service.MahasiswaService;
import com.ppk.penugasan1.entity.Mahasiswa;
import com.ppk.penugasan1.mapper.MahasiswaMapper;
import com.ppk.penugasan1.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author seizr
 */
@Service
public class MahasiswaServiceImplements implements MahasiswaService{
    private final MahasiswaRepository mahasiswaRepository;

    @Autowired
    public MahasiswaServiceImplements(MahasiswaRepository mahasiswaRepository) {
        this.mahasiswaRepository = mahasiswaRepository;
    }

    @Override
    public List<MahasiswaDTO> ambilData() {
        List<Mahasiswa> students = mahasiswaRepository.findAll();
        // konversi obj student ke studentDto satu per satu dengan fungsi map()
        List<MahasiswaDTO> dtos = students.stream()
                .map((student) -> (MahasiswaMapper.mapToMahasiswaDTO(student)))
                .collect(Collectors.toList());
        return dtos;
    }

    @Override
    public List<MahasiswaDTO> ambilDataByNama(String nama) {
        List<Mahasiswa> nstudents = mahasiswaRepository.findByNamaContainingIgnoreCase(nama);
        List<MahasiswaDTO> dtos = nstudents.stream()
                .map((nstudent) -> (MahasiswaMapper.mapToMahasiswaDTO(nstudent)))
                .collect(Collectors.toList());
        return dtos;
    }

    @Override
    public MahasiswaDTO ambilDataByNIM(String nim) {
        Mahasiswa mahasiswa = mahasiswaRepository.findByNim(nim);
        if (mahasiswa != null) {
            return MahasiswaMapper.mapToMahasiswaDTO(mahasiswa);
        }
        return null; // Handle ketika NIM mahasiswa tidak ditemukan
    }

    @Override
    public void perbaruiDataByNIM(String nim, MahasiswaDTO updatedMahasiswaDTO) {
        // Cari Mahasiswa berdasarkan NIM
        Mahasiswa dataMahasiswa = mahasiswaRepository.findByNim(nim);

        if (dataMahasiswa != null) {
           // Update data mahasiswa dengan valude yang baru
           dataMahasiswa.setNama(updatedMahasiswaDTO.getNama());
           dataMahasiswa.setJurusan(updatedMahasiswaDTO.getJurusan());
           dataMahasiswa.setTanggalLahir(updatedMahasiswaDTO.getTanggalLahir());

           // Simpan data mahasiswa yang baru
            mahasiswaRepository.save(dataMahasiswa);
        } else {
            // Handle jika mahasiswa dengan NIM tersebut tidak ditemukan
        }
    }

    @Override
    public void hapusDataByNIM(String nim) {
        // Cari Mahasiswa berdasarkan NIM
        Mahasiswa mahasiswa = mahasiswaRepository.findByNim(nim);

        if (mahasiswa != null) {
            // Hapus Data mahasiswa
            mahasiswaRepository.delete(mahasiswa);
        } else {
            // handle jika nim tidak ditemukan
        }
    }

    @Override
    public void simpanData(MahasiswaDTO mahasiswaDTO) {
        Mahasiswa mahasiswa = MahasiswaMapper.mapToMahasiswa(mahasiswaDTO);
        mahasiswaRepository.save(mahasiswa);
    }
    
}
