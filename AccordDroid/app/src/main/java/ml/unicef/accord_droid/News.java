package ml.unicef.accord_droid;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class News extends Base {

    private ListView mListView;
//    private ArrayAdapter<NewsData> listAdapter ;
    private SimpleAdapter adapter;

    List<Map<String, ?>> list = new ArrayList<Map<String, ?>>();
    private final static String TAG = Constants.getLogTag("Home");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);

        ImageView myText = findViewById(R.id.icon );
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(700); //You can manage the blinking time with this parameter
        anim.setStartOffset(0);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        myText.startAnimation(anim);
        if (isOnline()) {
            setupUIi();
        } else {
            Toast.makeText(News.this, "Vous êtes en mode hors connexion",
                    Toast.LENGTH_LONG).show();
        }

    }

    private void setupUIi() {
        String htmlString = "<html><body>\n" +
                "<iframe src=\"https://www.facebook.com/plugins/page.php?href=https%3A%2F%2Fwww.facebook.com%2FMinist%25C3%25A8re-de-la-R%25C3%25A9conciliation-Nationale-1631784637066809%2F%3F__tn__%3DkC-R%26eid%3DARBmp3ZPjg79yovUgn1MyRxvJb0TM6C6JmQAA97Uk3HbcGY4DOkU_9SCfw6UScFxaOYIQPjfAH_-WeZ1%26hc_ref%3DARSxnSrBOZkz3NaNzfYNWGwf8tZDeWcxcLkzK7Lxj7NC2ANwuRNyRSpVDDhFwdWHBz8%26__xts__[0]%3D68.ARBfs8mAUeyPCLwnQKso2icfUg0ef0Yr80WgOeBfyKM27YGEUSN7F4Gs1plz5kNUMSdRlFyLHsWa-ndAhDMAOM3l4raVNDYLHj9bO_yBrhR3gj38M1dkbEpTyTJeUYrzq-huMMqV7ixhvlZB_3YxC-32kFAq2BBnRMiUYr9EPC8v-B6vKz6ScX1moJGLa3xaIPItS5Tki5AWxD6J3UHPOJA0jnsRrK71chUOevbxp5zEPXtXSKrCQ-9ERjVX8gV76I-IwLSiVhxlCz143WlM-r7w20auNstdZHA7tk-hO13qtXPJvzJWSN9qv2Sc6RvIqNvFLzQ7lucyBCialrlcxr5tix65fflXtxM308FmrJMWdB8E-6qGBi2-JGSOEQ0py8b8HNQsjKknP8LYD32yWjzDvg1uSAvhaLcMvjqKDSsGRo4L9TIQmaCe0oobkWNJPftIkJakz7HoCnZ0qJNmF1EqI4Sn4jgpEZEOLZ2YlSjSu4P1RH_1Mp5pbOMnkQ&tabs=timeline&width=1000&height=1000&small_header=true&adapt_container_width=false&hide_cover=true&show_facepile=false&appId\" width=\"1000\" height=\"1000\" style=\"border:none;overflow:hidden\" scrolling=\"no\" frameborder=\"0\" allowTransparency=\"true\" allow=\"encrypted-media\"></iframe>"+
                "</body>\n</html>";

        WebView webView = findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadDataWithBaseURL(null, htmlString, "text/html", "utf-8", null);
    }

}