package luxoft.ch.toll;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TollRoadTrip {

	enum Choice {
		MONEY, COUPON
	}

	private final List<Integer> costs;

	public TollRoadTrip(List<Integer> costs) {
		this.costs = costs;
	}

	public List<Choice> solve(Integer money, Integer coupons) {
		Choice[] solution = new Choice[costs.size()];
		int level = choose(0, solution, 0, money, coupons);
		return Arrays.asList(Arrays.copyOf(solution, level + 1));
	}

	private int choose(int pathLength, Choice[] choices, int level, Integer money, Integer coupons) {
		if (level >= costs.size()) {
			return costs.size() - 1;
		}
		int currentCost = costs.get(level);
		int moneyLevel = -1;
		if (money >= currentCost) {
			moneyLevel = choose(pathLength, choices, level + 1, money - currentCost, coupons);
		}
		int couponLevel = -1;
		if (coupons >= 1) {
			couponLevel = choose(Math.max(pathLength, moneyLevel), choices, level + 1, money, coupons - 1);
		}
		if (moneyLevel == -1 && couponLevel == -1) {
			return level - 1;
		} else {
			if (pathLength >= Math.max(moneyLevel, couponLevel)) {
				return pathLength;
			}
			if (moneyLevel >= couponLevel) {
				choices[level] = Choice.MONEY;
				return moneyLevel;
			} else {
				choices[level] = Choice.COUPON;
				return couponLevel;
			}
		}
	}

	public static void main(String[] args) {
		TollRoadTrip trip = new TollRoadTrip(List.of(100, 50, 25, 12, 6, 3, 3, 2, 20, 30));
		List<Choice> choices = trip.solve(101, 2);
		System.out.println(choices.stream().map(Choice::toString).collect(Collectors.joining(",", "[", "]")));
	}

}
