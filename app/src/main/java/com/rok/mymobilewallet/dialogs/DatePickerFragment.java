package com.rok.mymobilewallet.dialogs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import com.rok.mymobilewallet.utils.BundleUtil;

import java.util.Calendar;
import java.util.Date;

import io.reactivex.annotations.Nullable;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    public interface OnDateChangeListener {
        void onDateChanged(Date date);
    }

    public static final String TAG = "DATE_PICKER_TAG";

    private static final String BUNDLE_KEY_DATE = "date";

    private Date selectedDate;
    private OnDateChangeListener listener;

    public static DatePickerFragment newInstance(@Nullable Date selectedDate) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(BUNDLE_KEY_DATE, selectedDate);

        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.setArguments(bundle);
        return datePickerFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selectedDate = BundleUtil.getExtras(getArguments(), BUNDLE_KEY_DATE);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        if (selectedDate != null) {
            c.setTime(selectedDate);
        }
        return new DatePickerDialog(getActivity(), this, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
    }

    public void setOnDateChangeListener(OnDateChangeListener listener) {
        this.listener = listener;
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);

        if (listener != null) {
            listener.onDateChanged(calendar.getTime());
        }
    }
}