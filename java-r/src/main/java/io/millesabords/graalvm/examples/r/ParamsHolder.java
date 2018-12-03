package io.millesabords.graalvm.examples.r;

import java.util.Arrays;


/**
 * Use to provide parameters to R code (function: plotRevenue).
 */
public class ParamsHolder {

    public String filename;
    public Integer[] trilogies;

    public ParamsHolder(String filename, String trilogies) {
        this.filename = filename;
        this.trilogies = trilogies == null ? null :
               Arrays.stream(trilogies.split(",")).map(Integer::parseInt).toArray(Integer[]::new);
                        //.collect(toList());
    }
}
