package co.unicauca.service.microservices.microserviceproduct.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_categories")
@Getter //Esto lo hace Lombok, genera getters así de simple
@Setter //Genera setters así de simple. Si quisieramos aún algo mejor, se puede usar @Data, para generar getters, setters, toString, etc
@AllArgsConstructor @NoArgsConstructor @Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
