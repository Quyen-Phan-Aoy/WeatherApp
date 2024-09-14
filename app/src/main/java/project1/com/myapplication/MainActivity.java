package project1.com.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

    public class MainActivity extends AppCompatActivity {

        private Spinner citySpinner;
        private TextView weatherResult;
        private Button getWeatherButton;
        private ImageView weatherImage;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Ánh xạ các thành phần UI
            citySpinner = findViewById(R.id.citySpinner);
            weatherResult = findViewById(R.id.weatherResult);
            getWeatherButton = findViewById(R.id.getWeatherButton);
            weatherImage = findViewById(R.id.weatherImage);

            // Tạo dữ liệu danh sách các thành phố
            String[] cities = {"Select","Hà Nội", "Hồ Chí Minh", "Đà Nẵng"};

            // Sử dụng ArrayAdapter để tạo danh sách thả xuống cho Spinner
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, cities);

            // Gán Adapter cho Spinner
            citySpinner.setAdapter(adapter);

            // Thiết lập sự kiện cho nút "Xem dự báo"
            getWeatherButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Lấy tên thành phố được chọn từ Spinner
                    String selectedCity = citySpinner.getSelectedItem().toString();

                    // Hiển thị dự báo thời tiết tương ứng với thành phố được chọn
                    String weatherInfo = getWeatherData(selectedCity);
                    weatherResult.setText(weatherInfo);

                    // Cập nhật hình ảnh thời tiết tương ứng
                    updateWeatherImage(selectedCity);
                }
            });
        }

        // Hàm giả lập dữ liệu thời tiết
        private String getWeatherData(String city) {
            switch (city) {
                case "Hà Nội":
                    return "Thời tiết tại Hà Nội: 30°C, Trời nắng, Độ ẩm 60%, Gió 10 km/h";
                case "Hồ Chí Minh":
                    return "Thời tiết tại Hồ Chí Minh: 32°C, Mưa rào, Độ ẩm 80%, Gió 15 km/h";
                case "Đà Nẵng":
                    return "Thời tiết tại Đà Nẵng: 28°C, Có mây, Độ ẩm 65%, Gió 12 km/h";
                default:
                    return "Không có dữ liệu thời tiết";
            }
        }

        // Hàm cập nhật hình ảnh dựa trên thành phố được chọn
        private void updateWeatherImage(String city) {
            switch (city) {
                case "Hà Nội":
                    weatherImage.setImageResource(R.drawable.sunny);  // Hiển thị hình ảnh trời nắng
                    break;
                case "Hồ Chí Minh":
                    weatherImage.setImageResource(R.drawable.rainy);  // Hiển thị hình ảnh trời mưa
                    break;
                case "Đà Nẵng":
                    weatherImage.setImageResource(R.drawable.windy); // Hiển thị hình ảnh trời có mây
                    break;
                default:
                    weatherImage.setImageResource(R.drawable.default_weather);  // Hình ảnh mặc định nếu không có dữ liệu
                    break;
            }
        }
    }

