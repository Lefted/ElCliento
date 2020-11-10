package us.hemdgang.values;

import java.util.function.Consumer;

/**
 * Project: LiquidBase
 * -----------------------------------------------------------
 * Copyright � 2017 | CCBlueX | All rights reserved.
 */
public class Value<T> {

    private String valueName;
    private T valueObject;

    private Consumer<T> consumer;

    public Value(String valueName, T defaultValueObject) {
	this.valueName = valueName;
	this.valueObject = defaultValueObject;
    }

    public String getValueName() {
	return valueName;
    }

    public T getObject() {
	return valueObject;
    }

    public void setConsumer(Consumer<T> consumer) {
	this.consumer = consumer;
    }

    public void setObject(T valueObject) {
	this.valueObject = valueObject;
	// TODO save module config
	// UtilityMod.instance.moduleConfig.saveModules();
	if (this.consumer != null) {
	    this.consumer.accept(this.valueObject);
	}
    }
}