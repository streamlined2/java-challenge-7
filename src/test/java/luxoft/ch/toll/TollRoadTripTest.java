package luxoft.ch.toll;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
 
import java.util.List;
 
import org.junit.jupiter.api.Test;
 
import luxoft.ch.toll.TollRoadTrip.Choice;
import static luxoft.ch.toll.TollRoadTrip.Choice.COUPON;
import static luxoft.ch.toll.TollRoadTrip.Choice.MONEY;
 
class TollRoadTripTest {
      
       @Test
       void testNeedCouponFromTheStart() {
             TollRoadTrip tollRoadTrip = new TollRoadTrip(List.of(10, 1, 1, 1, 10, 1, 1, 1, 1, 1));
             final List<Choice> payStrategy = tollRoadTrip.solve(2, 1);
             assertArrayEquals(new Choice[] {COUPON, MONEY, MONEY}, payStrategy.toArray(new Choice[0]));
       }
 
 
       @Test
       void test2coupons() {
             TollRoadTrip tollRoadTrip = new TollRoadTrip(List.of(1, 1, 10, 1, 10, 1, 1, 1, 1, 1));
             final List<Choice> payStrategy = tollRoadTrip.solve(4, 2);
             assertArrayEquals(new Choice[] {MONEY, MONEY, COUPON, MONEY, COUPON, MONEY}, payStrategy.toArray(new Choice[0]));
       }
      
       @Test
       void test2coupons3() {
             TollRoadTrip tollRoadTrip = new TollRoadTrip(List.of(1, 3, 3, 1, 1, 1, 1, 1, 1));
             final List<Choice> payStrategy = tollRoadTrip.solve(4, 2);
             assertArrayEquals(new Choice[] {MONEY, COUPON, COUPON, MONEY, MONEY, MONEY}, payStrategy.toArray(new Choice[0]));
       }
 
       @Test
       void test3coupons2() {
             TollRoadTrip tollRoadTrip = new TollRoadTrip(List.of(1, 5, 4, 2, 4, 2, 2, 1, 1));
             final List<Choice> payStrategy = tollRoadTrip.solve(6, 3);
             for (Choice payType : payStrategy) {
                    System.out.println(payType);
             }
             assertArrayEquals(new Choice[] {MONEY, COUPON, COUPON, MONEY, COUPON, MONEY }, payStrategy.toArray(new Choice[0]));
       }
 
 
}
