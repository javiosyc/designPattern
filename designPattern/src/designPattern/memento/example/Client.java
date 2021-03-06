package designPattern.memento.example;

public class Client {

	public static void main(String[] args) {
		FlowAMock mock = new FlowAMock("TestFlow");
		
		mock.runPhaseOne();
		
		FlowAMementoCareTaker careTaker = new FlowAMementoCareTaker();
		
		FlowAMockMemento memento = mock.createMemento();
		
		careTaker.saveMemento(memento);
		
		mock.schema1();
		
		mock.setMemento(memento);
		
		mock.schema2();
	}

}
