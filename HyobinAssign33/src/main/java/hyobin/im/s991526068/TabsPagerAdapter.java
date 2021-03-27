package hyobin.im.s991526068;

import android.content.Context;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES =
            new int[] { R.string.tab1_text, R.string.tab2_text, R.string.tab3_text };
    private final Context mContext;

    public TabsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return HyobinFragment.newInstance();
            case 1:
                return ImFragment.newInstance();
            case 2:
                return S991526068Fragment.newInstance();
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }
}