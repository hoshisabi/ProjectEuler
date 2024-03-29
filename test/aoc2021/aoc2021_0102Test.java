package aoc2021;

import aoc2021.aoc2021_0102;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class aoc2021_0102Test extends TestCase
{

  @Test
  public void testDepthCount()
  {
    // Given this known set of distances
    List<Integer> testArray = Arrays.asList(199, 200, 208, 210, 200, 207, 240, 269, 260, 263);

    // when I run the test count
    int counts = aoc2021_0102.countLarger(testArray);

    // then I get 7
    assertThat(counts).isEqualTo(5);
  }
}