package com.solvd.library.util;

import com.solvd.library.entities.Client;

@FunctionalInterface
public interface ICheckCard {
	boolean checkCard(Client client);
}
