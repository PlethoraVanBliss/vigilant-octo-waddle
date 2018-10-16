package de.demo.valet.service;

import de.demo.valet.domain.Valet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;

@Service
@AllArgsConstructor
public class ValetService {

    @Nonnull
    public Valet getValet(int valetId){
        return createDummyValet(valetId);
    }

    private static Valet createDummyValet(int valetId){
        return Valet.builder().id(valetId).name(System.currentTimeMillis()+"-name").build();
    }
}
