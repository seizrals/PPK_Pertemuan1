/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ppk.penugasan1.mapper;

import com.ppk.penugasan1.dto.MahasiswaDTO;
import com.ppk.penugasan1.entity.Mahasiswa;
/**
 *
 * @author seizr
 */
public class MahasiswaMapper {
    // map Student entity ke Student Dto
    public static MahasiswaDTO mapToMahasiswaDTO(Mahasiswa mahasiswa) {
        // Membuat dto dengan builder pattern (inject dari lombok)
        MahasiswaDTO mahasiswaDTO = MahasiswaDTO.builder()
                .id(mahasiswa.getId())
                .nim(mahasiswa.getNim())
                .nama(mahasiswa.getNama())
                .jurusan(mahasiswa.getJurusan())
                .tanggalLahir(mahasiswa.getTanggalLahir())
                .build();
        return mahasiswaDTO;
    }

    // map Student Dto ke Student Entity
    public static Mahasiswa mapToMahasiswa(MahasiswaDTO mahasiswaDto) {
        Mahasiswa mahasiswa = Mahasiswa.builder()
                .id(mahasiswaDto.getId())
                .nim(mahasiswaDto.getNim())
                .nama(mahasiswaDto.getNama())
                .jurusan(mahasiswaDto.getJurusan())
                .tanggalLahir(mahasiswaDto.getTanggalLahir())
                .build();
        return mahasiswa;
    }
}
