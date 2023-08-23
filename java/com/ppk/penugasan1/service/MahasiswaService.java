/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ppk.penugasan1.service;

import com.ppk.penugasan1.dto.MahasiswaDTO;
import java.util.List;


/**
 *
 * @author seizr
 */

public interface MahasiswaService {
    public List<MahasiswaDTO> ambilData();

    public List<MahasiswaDTO> ambilDataByNama(String nama);

    public MahasiswaDTO ambilDataByNIM(String nim);

    public void perbaruiDataByNIM(String nim, MahasiswaDTO updatedMahasiswaDTO);

    public void hapusDataByNIM(String nim);

    public void simpanData(MahasiswaDTO mahasiswaDTO);
}
