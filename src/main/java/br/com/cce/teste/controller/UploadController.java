package br.com.cce.teste.controller;

import br.com.cce.teste.enumeration.TipoValorEnum;
import br.com.cce.teste.exception.ApiException;
import br.com.cce.teste.service.IAgenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UploadController {

    @Autowired
    IAgenteService agenteService;

    @GetMapping("/media/{sigla}")
    public ResponseEntity valor(@PathVariable String sigla) {
        Double media = agenteService.retornaValorMedioTipoRegiao(TipoValorEnum.GERACAO,sigla);
        return ResponseEntity.ok(media);
    }

    @PostMapping("/upload")
    @CrossOrigin
    public ResponseEntity uploadFiles(@RequestParam("arquivo") String arquivo) {
        try{
            agenteService.salvar(arquivo);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            if(e instanceof ApiException)
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            else
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

