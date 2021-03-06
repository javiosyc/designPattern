package designPattern.command.example;

public class OpenCommand implements Command {

	private MainBoardApi mainBoard = null;

	public OpenCommand(MainBoardApi mainBoard) {
		this.mainBoard = mainBoard;
	}

	@Override
	public void execute() {
		this.mainBoard.open();
	}
}
