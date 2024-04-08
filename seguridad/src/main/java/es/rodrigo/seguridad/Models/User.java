package es.rodrigo.seguridad.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String nick;
    private String name;

    @Entity
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name = "Role")
    public static class Role {

        @Id
        @GeneratedValue()
        @Column(name = "id")
        private int id;

        @Column(name = "name")
        private String name;

        public String name() {
            return name;
        }
    }
}

