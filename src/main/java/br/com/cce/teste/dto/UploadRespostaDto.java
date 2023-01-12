package br.com.cce.teste.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UploadRespostaDto {
    private int id;
    private String nomeArquivo;
}
