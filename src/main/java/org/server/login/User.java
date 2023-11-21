package org.server.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.server.request.Request;

import javax.persistence.*;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @OneToMany(mappedBy = "users")
    private List<Request> requestList;
    private int role;
    private String login;
    private String password;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}