package com.ozer.productivo;


import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;

public class CustomStrikethroughSpan extends CharacterStyle implements UpdateAppearance {

    private int color;
    private float thickness;

    public CustomStrikethroughSpan(int color, float thickness) {
        this.color = color;
        this.thickness = thickness;
    }

    @Override
    public void updateDrawState(TextPaint tp) {
        tp.setStrikeThruText(true);
        tp.setColor(color);
        tp.setStrokeWidth(thickness);
    }

    public void updateMeasureState(TextPaint tp) {
        tp.setStrikeThruText(true);
        tp.setColor(color);
        tp.setStrokeWidth(thickness);
    }
}

