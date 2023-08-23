/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ppk.penugasan1.repository;

import com.ppk.penugasan1.entity.Mahasiswa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Repository;
/**
 *
 * @author seizr
 */
@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long>{
    Mahasiswa findByNim(String nim);
    
    List<Mahasiswa> findByNamaContainingIgnoreCase(String nama);
}
