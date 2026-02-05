package com.ian.springmvcproject.basic;

import lombok.Data;

/**
 * @Getter
 * @Setter
 * @RequiredArgsConstructor
 * @ToString
 * @EqualsAndHashCode
 */
@Data
public class HelloData {

    private String username;
    private int age;
}
