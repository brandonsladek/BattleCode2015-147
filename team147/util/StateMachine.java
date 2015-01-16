package team147.util;

import team147.BaseRobot;

public abstract class StateMachine {
	protected BaseRobot br;

	public StateMachine(BaseRobot br) {
		this.br = br;
	}

	public enum State {
		ATTACK, DEFEND, ECON, EXPLORE, PANIC
	}

	public abstract State updateState();

	public abstract void sendStateMessages();
}
