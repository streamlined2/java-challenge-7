package luxoft.ch.list;

import java.util.Objects;

public class LinkedList {

	private static final int NOT_FOUND = -1;

	private final ListNode listHead;

	public LinkedList(Object value) {
		this.listHead = new ListNode(value);
	}

	public LinkedList add(Object value) {
		ListNode tail = getTail();
		tail.next = new ListNode(value);
		return this;
	}

	public ListNode getTail() {
		ListNode currentNode = listHead;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		return currentNode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		ListNode currentNode = listHead;
		do {
			builder.append(currentNode.value.toString());
			if (currentNode.next != null) {
				builder.append(",");
			}
			currentNode = currentNode.next;
		} while (currentNode != null);
		return builder.toString();
	}

	public void loopTail(Object nodeValue) {
		ListNode node = getNode(nodeValue);
		if (node != null) {
			getTail().next = node;
		}
	}

	public ListNode getNode(Object value) {
		ListNode currentNode = listHead;
		while (currentNode != null) {
			if (Objects.equals(currentNode.value, value)) {
				return currentNode;
			}
			currentNode = currentNode.next;
		}
		return null;
	}

	public int getFirstOccurence(Object value) {
		int count = 0;
		ListNode currentNode = listHead;
		while (currentNode != null) {
			if (Objects.equals(currentNode.value, value)) {
				return count;
			}
			currentNode = currentNode.next;
			count++;
		}
		return NOT_FOUND;
	}

	public int getFirstOccurence(ListNode node) {
		int count = 0;
		ListNode currentNode = listHead;
		while (currentNode != null) {
			if (currentNode == node) {
				return count;
			}
			currentNode = currentNode.next;
			count++;
		}
		return NOT_FOUND;
	}

	public boolean hasLoop() {
		int count = 0;
		for (ListNode currentNode = listHead; currentNode != null; currentNode = currentNode.next, count++) {
			if (getFirstOccurence(currentNode) < count) {
				return true;
			}
		}
		return false;
	}

	public static void main(String... args) {
		LinkedList linkedList = new LinkedList("A").add("B").add("C").add("D").add("E").add("F").add("G").add("H")
				.add("I").add("J").add("K");
		System.out.println(linkedList.toString());
		System.out.println(linkedList.getFirstOccurence("F"));
		System.out.println(linkedList.hasLoop()?"list has loop":"list has no loop");
		linkedList.loopTail("F");
		System.out.println(linkedList.hasLoop()?"list has loop":"list has no loop");
	}

}
