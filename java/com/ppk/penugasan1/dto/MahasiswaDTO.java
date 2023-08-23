/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ppk.penugasan1.dto;

import com.ppk.penugasan1.entity.Mahasiswa;
import lombok.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
/**
 *
 * @author seizr
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MahasiswaDTO {
    private Long id;

    @NotEmpty(message = "NIM tidak boleh kosong!")
    private String nim;

    @NotEmpty(message = "Nama tidak boleh kosong!")
    private String nama;

    @NotNull(message = "Jurusan tidak boleh kosong!")
    private Mahasiswa.Jurusan jurusan;

    @NotNull(message = "Tanggal Lahir tidak boleh kosong!")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate tanggalLahir;
}
