public class MainActivity extends AppCompatActivity {
    private GLSurfaceView glSurfaceView;
    private OpenGLRenderer renderer;
    private CameraManager cameraManager;
    private Button toggleButton;
    private boolean isEdgeDetectionEnabled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initializeComponents();
        setupCamera();
        setupOpenGL();
    }

    private void initializeComponents() {
        glSurfaceView = findViewById(R.id.gl_surface_view);
        toggleButton = findViewById(R.id.toggle_button);
        
        toggleButton.setOnClickListener(v -> {
            isEdgeDetectionEnabled = !isEdgeDetectionEnabled;
            renderer.setEdgeDetectionEnabled(isEdgeDetectionEnabled);
            toggleButton.setText(isEdgeDetectionEnabled ? "Raw Feed" : "Edge Detection");
        });
    }
}