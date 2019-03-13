package com.stackroute.foodservice.domain;

/*import statements for lombok*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*import statements for jpa*/
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
/*automatically generates getter,setter,hashcode,equals method etc */
@Data
/*automatically generates no argument constructor*/
@NoArgsConstructor
/*automatically generates all argument constructor*/
@AllArgsConstructor
public class Customer {

    /*makes restaurant id as a primary key*/
    @Id
    private int restaurantId;
    private String restaurantName;
    private String address;
    private String city;

}

