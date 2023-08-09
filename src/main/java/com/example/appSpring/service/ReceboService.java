package com.example.appSpring.service;

import com.example.appSpring.DTO.Recebo;
import com.example.appSpring.entity.Mostrar;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;

@Service
public class ReceboService {

    private Mostrar mostrar;

    public Mostrar verify(final Recebo recebo){
        media(recebo);
        satanas(recebo);
        tamanho(recebo);
        mediana(recebo);

       return  new Mostrar(media(recebo),satanas(recebo),mediana(recebo),tamanho(recebo));
    }



    public Double media(Recebo recebo){

        Double media,soma = 0.0;

        for(Double i : recebo.getNumeroList()){
            soma += i;
        }
        System.out.println("soma"+soma);

       media = soma / recebo.getNumeroList().size();

//        mostrar.setMedia(media);
        System.out.println("media"+media);
        return media;

    }

    public Double satanas(Recebo recebo){
        Double result = 0.0, raiz = 0.0;
        Double i = media(recebo);

        for(Double j: recebo.getNumeroList()){

          Double quadrado = Math.pow(j-i, 2);
          result += quadrado;
        }

        result /= recebo.getNumeroList().size();

       raiz = Math.sqrt(result);

//       mostrar.setDesvioPadrao(raiz);
        System.out.println("raiz"+raiz);
        return raiz;
    }

    public int tamanho(Recebo recebo){
//        mostrar.setQtd(recebo.getNumeroList().size());
        return recebo.getNumeroList().size();
    }

    public Double mediana(Recebo recebo){

        Double k;

        Collections.sort(recebo.getNumeroList());

        int meio = recebo.getNumeroList().size() / 2;

        if(recebo.getNumeroList().size() % 2 == 1){
//            mostrar.setMediana(recebo.getNumeroList().get(meio));
            return recebo.getNumeroList().get(meio);
        }else{
            k = recebo.getNumeroList().get(meio - 1) + recebo.getNumeroList().get(meio) / 2;
//            mostrar.setMediana(k);

            return k;
        }
    }

}
