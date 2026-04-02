package com.social.media.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "social_user")
    @JsonIgnore
    private SocialUser user;

    private String description;


    //Metodo para mantener la coherencia en ambos lados de la relación bidireccional
    public void setSocialUser(SocialUser su) {
        this.user = su;
        if(user.getSocialProfile() != this)
            user.setSocialProfile(this);
    }
}
