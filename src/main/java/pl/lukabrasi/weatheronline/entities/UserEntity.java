package pl.lukabrasi.weatheronline.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "weather_user")
public class UserEntity {

    private @Id
    @GeneratedValue
    int id;
    private String login;
    private String password;
    private String email;
}
