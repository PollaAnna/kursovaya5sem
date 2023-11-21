package org.server.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.server.login.User;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "request")
public class Request {

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;
    private String status;
    private String content;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
