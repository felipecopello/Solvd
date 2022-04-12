package com.solvd.library.util;

import com.solvd.library.entities.Client;

@FunctionalInterface
public interface ICalculate {
	int operation(Client a, Client b);
}
