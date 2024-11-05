package com.example.tingeso.services;

import com.example.tingeso.entities.EmpleadoEntity;
import com.example.tingeso.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    public ArrayList<EmpleadoEntity> obtenerEmpleados(){
        return (ArrayList<EmpleadoEntity>) empleadoRepository.findAll();
    }

    public String obtenerCategoria(String rut){
        return empleadoRepository.findCategory(rut);
    }

    public EmpleadoEntity findByRut(String rut){
        return empleadoRepository.findByRut(rut);
    }

    // Vulnerable method to Remote Code Execution
    public void executeCommand(String command) {
        try {
            // Unsafe execution of a command based on user input
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Vulnerable method due to lack of input validation
    public void processEmployeeInput(String employeeData) {
        // No validation on the format or content of employeeData
        System.out.println("Processing employee data: " + employeeData);

        // Assuming some internal processing here without sanitizing the input
        if (employeeData.contains("admin")) {
            System.out.println("Employee has admin privileges");
        }
    }

}
