# KCC Coding Test
Coding Test App for Kin+Carta Create

### Test Description

[Kin+Carta Create Engineering Challenge](https://github.com/theappbusiness/engineering-challenge)

### Packages

- `di`
  
  Dependency Injection | Multiple modules that provide various required dependencies throughout the project
  
- `domain`
  
  Domain Models | Local models for the incoming data and mappers to convert network models
  
- `network`
  
  Network Models | Models for network JSON file and the corresponding responses are stored here along with the NetworkService Interface
  
- `persistence`
  
  Local Storage | Persisting the theme of the application set by user
  
- `presentation`
  
  View & ViewModels | All the Fragments, their ViewModels and the host activities are written here
  
- `util`
  
  Utilities | Files for general purpose to provide additional functionalities
  

### UI Tests

- BasicTests.kt | Run the basic tests to test the working of app
- NavigationTest.kt | To check the navigation between fragments
- CaseStudyCardKtTest.kt | To check the working of CaseStudyCard Composable
- SectionViewKtTest.kt | To check the working of SectionViewK Composable

### Libraries

1. [Jetpack Compose](https://developer.android.com/jetpack/compose)
2. [Retrofit2](https://square.github.io/retrofit/)
3. [Hilt](https://dagger.dev/hilt/)
4. [Jetpack Datastore](https://developer.android.com/topic/libraries/architecture/datastore)
