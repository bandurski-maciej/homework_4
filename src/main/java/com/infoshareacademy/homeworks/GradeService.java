package com.infoshareacademy.homeworks;


import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;


public class GradeService {

  public String[][] calculateAverage(String[][] data) {

    return (data == null || data.length == 0) ? new String[][]{,} :
      Arrays.stream(data)
        .collect(groupingBy(s -> s[0],
          averagingDouble(s -> Integer.parseInt(s[1]))))
        .entrySet()
        .stream()
        .sorted(Map.Entry.comparingByKey())
        .map(e -> new String[]{e.getKey(), new DecimalFormat("0.00").format(e.getValue())})
        .toArray(String[][]::new);
  }

}
