package com.example.projeto_11_sensores_listar_sensores;

import android.hardware.Sensor;

public class MySensor {
	Sensor sensor;
	float valor;
	
	public MySensor(Sensor sensor, float valor) {
		this.sensor = sensor;
		this.valor = valor;
	}
	
	public Sensor getSensor() {
		return sensor;
	}
	
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
	
	public float getValor() {
		return valor;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}
}
