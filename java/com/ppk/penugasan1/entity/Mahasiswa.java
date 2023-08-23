/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ppk.penugasan1.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
/**
 *
 * @author seizr
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "mahasiswa")
public class Mahasiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nim", nullable = false, unique = true)
    private String nim;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Enumerated(EnumType.STRING)
    @Column(name = "jurusan", nullable = false)
    private Jurusan jurusan;

    @Column(nullable = false)
    private LocalDate tanggalLahir;

    public enum Jurusan {
        D3_Statistika, D4_Komputasi, D4_Statistika
    }
}
