## By Martin Chamarro for ASOS

___
Copyright 2020 Martin Chamarro (@martinchamarro)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
___

The project is coded 100% in Kotlin

#### Architecture
The selected architecture for the project is Clean Architecture. There are 3 main layers:
- **Data layer**. Includes:
    - A Repository, that wraps the Data Sources (API, Cache).
    - The API is implemented using Retrofit2. There is a **custom cache** that stores all the network responses for 1 hour. It also is available when the device is offline, so the app works without Internet connection.
    - A basic in-memory cache.
    - All the entity classes. They include the Gson annotations.
    - All the mappers that convert entity objects in domain objects.
- **Domain layer**. Includes:
    - Asynchronous UseCases implemented with RxJava2.
    - All the domain model classes.
- **Presentation layer**. Includes:
    - All the UI of the application. Each screen is implemented using a Model-View-Presenter (MVP) Pattern
    - There are contracts that define the interfaces of the Views and the Presenters.
    - Custom views, adapters, viewholders, etc.
    - The number of columns of the recipes grid depends of the device orientation.


#### Highlighted libraries of the project:
- Retrofit2
- Dagger2
- RxJava2
