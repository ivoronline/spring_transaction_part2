package com.ivoronline;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private int    id;
    private String name;
    private int    age;
}
