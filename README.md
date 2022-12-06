Android
1: Introduction to Android,  Lecture 4  and some slides fromLecture 5
	1.1 create new project instructions
		1.1.1 package name pt.ua.cm
		1.1.2 minimum SDK (API Levels) - latest
		1.1.3 App project structure
		1.1.4 ConstraintLayout(default), FrameLayout, LinearLayout
		1.1.5 Activity lifecycle: onCreate() -> created  -> onResume() -> displayed -> onPause() -> hidden
			1.1.5.1 Android provides mechanisms to track the moment of an action and react to it
		1.1.6 Log.i -> Logcat
	1.2 Two ways of getting the views
		1.2.1 findViewById(R.id.textView)
		1.2.2 better alternative: binding strategy: ActivityMainBinding, binding.name.text, binding.age.text
			1.2.2.1 “no more findViewById”
	1.3 React to actions of views
		1.3.1 onClick(), need to extend View.OnClickListener
	1.4 Layout configurations for different devices:
		1.4.1 dp - device-independent pixels - adapts to different screen resolutions
		1.4.2 sp - scalable pixels
	1.5 Res directory structure
		1.5.1 mipmap-* icons
		1.5.2 Android has convenient ways of providing different versions of the same resource
Homework 4,5
Notes: layouts and resources, we can use without xml -> compose(a library, layout in-code, flutter-like)

2: Activities and Fragments and Navigation
	2.1 Intent (specify Action, optional data) - opens an activity
		2.1.1 Explicit  (provide full path of an activity)
		2.1.2 Implicit (provide a location eg. Intent.ACTION_SEND)
		2.1.3 startActivity() transfers the focus (resolveActivity() checks if it is possible to run this intent)
	2.2 Navigation drawer - use bottom navigation instead of top AppBar, Navigation Editor
	2.3 Fragments (parts of an Activity) (reuse parts of the screen) (best practices)
		2.3.1 using fragments is the best practice
		2.3.2 instead of an Empty Project create Bottom Navigation Activity 
		2.3.3 Use only AndroidX version
	2.4 Fragment lifecycles — 
		2.4.1 Activities actions affects fragments that are inside
		2.4.2 onCreateView()
		2.4.3 miss management of lifecycles is the most common issues of mobile apps
		2.4.4 
	2.5 Logging
		2.5.1 adb - android debug bridge Log.i
Homework assignment #1.
- next week
- git repository (instructions)
- personal git repository for the course

3: Lists of Data and Application structure
	3.1 lists of data: RecyclerView. (slide 44)
	3.2 ViewModel (slide 10) (managing data states//ViewModels ) (Lifecycle)
		3.2.1 ViewModel outlives activity states
		3.2.2 Use ViewModels to keep data states inside an activity
	3.3 Data binding (a friend)
		3.3.1 Refer ViewModel from XML<data></data>
		3.3.2 android:text=“@{viewModel.scoreA.toString()}”
	3.4 LiveData
		3.4.1 Pattern: Observer (push elements to Observers)
		3.4.1 Observable, Observer, notify, observe() 
Homework:
Complete Activities Lesson 8 and 9
	3.5 Data Storage: app-storage, shared-storage, shared-preferences(simple), databases(more complex)
	3.6 Database
		3.6.1 local db: RoomDatabase: User(data class - ‘data’ means no methods, use helpful annotations @PrimaryKey, @ColumnInfo, @Entity), UserDao(interface to communicate, @Dao, @Query, @Insert, @Update, @Delete objects), UserDatabase(@Database, @Volatile)
	3.7 Backend Database - firebase(database not relational, auth)

Practice notes:
- Recycler view
- The core task in implementing a RecyclerView is creating the adapter.



4: Connecting to backend services
	4.1 UI controller -> ViewModel -> Repository(Remote data source, Room, MockBackend)
	4.3 Remote:
		4.3.1 @firebase
		4.3.2 (mBaaS) mobile backend as a service
			- User management
			- db (firestore)
			- (mm) storage
			- push notifications
			- (crash) analytics
		4.3.3 REST API (json)
	4.4 Add AndroidManifest internet permissions
	4.5 Defining Retrofit Service
	4.6 Lesson 12: Repository Pattern(a concept) and WorkManager
		4.6.1 WorkManager (a friend) (built-in SDK) to schedule background work tasks (eg. certain conditiones to send email)

Practical notes:
 - The app has a ViewModel for each fragment. Create a layer for the network service, and the ViewModel communicates directly with that network layer.

Homework Optional (2 weeks):
- get data from API using retrofit (java)
- wait for kotlin version
- find API server


Assessment:
HW & portfolio: 1
Exam: 2
App project: 7
Total : 10