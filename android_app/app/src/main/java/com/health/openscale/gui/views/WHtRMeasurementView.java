/* Copyright (C) 2014  olie.xdev <olie.xdev@googlemail.com>
*
*    This program is free software: you can redistribute it and/or modify
*    it under the terms of the GNU General Public License as published by
*    the Free Software Foundation, either version 3 of the License, or
*    (at your option) any later version.
*
*    This program is distributed in the hope that it will be useful,
*    but WITHOUT ANY WARRANTY; without even the implied warranty of
*    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*    GNU General Public License for more details.
*
*    You should have received a copy of the GNU General Public License
*    along with this program.  If not, see <http://www.gnu.org/licenses/>
*/
package com.health.openscale.gui.views;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;

import com.health.openscale.R;
import com.health.openscale.core.datatypes.ScaleData;
import com.health.openscale.core.evaluation.EvaluationResult;
import com.health.openscale.core.evaluation.EvaluationSheet;

public class WHtRMeasurementView extends MeasurementView {

    public WHtRMeasurementView(Context context) {
        super(context, context.getResources().getString(R.string.label_whtr), ContextCompat.getDrawable(context, R.drawable.ic_whtr));
    }

    @Override
    public boolean isEditable() {
        return false;
    }

    @Override
    public void updateValue(ScaleData updateData) {
        setValueOnView(updateData.getDateTime(), updateData.getWHtR(getScaleUser().body_height));
    }

    @Override
    public void updateDiff(ScaleData updateData, ScaleData lastData) {
        setDiffOnView(updateData.getWHtR(getScaleUser().body_height), lastData.getWHtR(getScaleUser().body_height));
    }

    @Override
    public String getUnit() {
        return "";
    }

    @Override
    public void updatePreferences(SharedPreferences preferences) {
        setVisible(preferences.getBoolean("waistEnable", false));
    }

    @Override
    public EvaluationResult evaluateSheet(EvaluationSheet evalSheet, float value) {
        return evalSheet.evaluateWHtR(value);
    }

    @Override
    public float getMinValue() {
        return 0;
    }

    @Override
    public float getMaxValue() {
        return 1;
    }

}
