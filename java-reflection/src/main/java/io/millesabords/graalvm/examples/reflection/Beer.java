package io.millesabords.graalvm.examples.reflection;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Beer {

    @NonNull private int id;
    @NonNull private String name;
    @NonNull private String country;
}
