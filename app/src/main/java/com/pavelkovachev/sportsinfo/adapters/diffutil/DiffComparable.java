package com.pavelkovachev.sportsinfo.adapters.diffutil;

public interface DiffComparable<T> {

    boolean isItemTheSameAs(T newItem);

    boolean areContentsTheSameAs(T newItem);

}