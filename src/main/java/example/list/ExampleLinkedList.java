package example.list;

import example.list.dto.Node;

public class ExampleLinkedList {
	private Node head;

	// Default constructor
	public ExampleLinkedList() {
	}

	// appends the specified element to the end of this list.
	public void add(int data) {
		// Initialize Node only incase of 1st element
		if (head == null) {
			head = new Node(data);
		}
		Node tempNode = new Node(data);
		Node currentNode = head;

		// Let's check for NPE before iterate over crunchifyCurrent
		if (currentNode != null) {

			// starting at the head node, crawl to the end of the list and then
			// add element after last node
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}

			// the last node's "next" reference set to our new node
			currentNode.setNext(tempNode);
		}
	}

	// Remove the tail element from a linkedlist
	public void removeTail() {
		Node currentNode = head;
		Node beforeNode = null;
		if (head != null) {
			if (currentNode.getNext() != null) {
				while (currentNode.getNext() != null) {
					beforeNode = currentNode;
					currentNode = currentNode.getNext();
				}
				beforeNode.setNext(null);
			} else
				head = null;
		}
	}

	// Remove all element in the linkedlist that is great than a target value
	public void removeAllGreatThan(int data) {
		Node currentNode = head;
		Node beforeNode = null;
		if (currentNode != null) {
			while (currentNode != null) {
				if (currentNode.getData() > data) {
					if (beforeNode != null) {
						beforeNode.setNext(currentNode.getNext());
					} else
						head = currentNode.getNext();
					currentNode = currentNode.getNext();
				} else {
					beforeNode = currentNode;
					currentNode = currentNode.getNext();
				}
			}
		}
	}

	public String toString() {
		String output = "";

		if (head != null) {
			Node currentNode = head.getNext();
			while (currentNode != null) {
				output += "[" + currentNode.getData() + "]";
				currentNode = currentNode.getNext();
			}

		}
		return output;
	}

	public static void main(String[] args) {
		ExampleLinkedList linkedList=new ExampleLinkedList();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		
		System.out.println(linkedList.toString());
		
		linkedList.removeAllGreatThan(1);
		System.out.println(linkedList.toString());
//		linkedList.removeTail();
//		System.out.println(linkedList.toString());
//		linkedList.removeTail();
//		System.out.println(linkedList.toString());

	}

}
