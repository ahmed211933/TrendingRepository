
# Treding Repository

The goal of this Project is to build a simple single-screen app that shows the current
trending Github repositories fetched from a public API.


## API Reference

#### Get all items

GET
https://private-anon-4e65c7dcc7-githubtrendingapi.apiary-mock.com/repositories?language=&since=daily&spoken_language_code=Parameters
language
Programming language
String
since
Trending period: daily, weekly, monthly Default: daily.
String
spoken_language_code


## Acknowledgements

 - [Awesome Readme ](https://githubtrendingapi.docs.apiary.io/#%23)
## Appendix

https://githubtrendingapi.docs.apiary.io/#%23


## Used By

This project is used by the following companies:

- Ahmed Ibrahim



## Screenshots

![Screenshot_20211231-204542_Trending](https://user-images.githubusercontent.com/74600737/147836730-c4af9d9f-b603-4f4a-8eab-a79a6ee6a4dc.jpg)   ![Screenshot_20211231-204707_Trending](https://user-images.githubusercontent.com/74600737/147836626-5a1d0b5e-b03d-4403-a795-bfd970d49823.jpg)  ![Screenshot_20211231-204711_Trending](https://user-images.githubusercontent.com/74600737/147836662-64c1caf1-6097-4e5e-bb43-1e3f11c96a29.jpg) ![Screenshot_20211231-204608_Trending](https://user-images.githubusercontent.com/74600737/147836684-d40de61a-1c17-4c05-9cc6-d5bc69e01d9c.jpg) ![Screenshot_20211231-204621_Trending](https://user-images.githubusercontent.com/74600737/147836700-7394004e-102e-400e-8b36-d62eee87dacf.jpg) ![Screenshot_20211231-204639_Trending](https://user-images.githubusercontent.com/74600737/147836709-e54c79b6-463b-41e5-9ba0-e48fd7c140dc.jpg)












## Tech Stack

**android studio IDE**
**kotlin programming language*
**MVVM Desgin pattern*
*using RX Java*
*using using retrofit to connect to server*

- MVVM
- Live Data
- Recycle view
- Data Binding
- Hilt
- Dependancy Injection
- Swip Refresh
-Shimmer Layout

![Logo](https://aqwas.sa/static/media/aqwasLogo.e7919109.svg)



## 🛠 Skills
android developer


## 🚀 About Me
I'm an android developer ...


## 🔗 Links

## Lessons Learned

i Learned alot of thing like how to get the
trending repositories from public api 
- MVVM
- Live Data
- Recycle view
- Data Binding
- Hilt
- Dependancy Injection
- Swip Refresh
-Shimmer Layout



## Usage/Examples

   private fun onScreenStateChanged(state: MakeenViewModel.ScreenState?) {
        when (state) {
            is MakeenViewModel.ScreenState.Loading -> footerAdapter.setLoading()
            is MakeenViewModel.ScreenState.SuccessAPIResponse -> handleSuccess(state.data)
            is MakeenViewModel.ScreenState.ErrorLoadingFromApi -> handleErrorLoadingFromApi(state.error)
        }
    }
## Installation

Install my-project with android Studio

## Features

- MVVM
- Live Data
- Recycle view
- Data Binding
- Hilt
- Dependancy Injection
- Swip Refresh
-Shimmer Layout


## Authors

- Ahmed Ibrahim


## Environment Variables

To run this project, you will need to add the following environment variables to your .env file

# Repositories/List Trending RepositoriesGET

# https://private-anon-9d2e142ad1-githubtrendingapi.apiary-mock.com/repositories?language=&since=daily&spoken_language_code=



# Hi, I'm ahmed Ibrhim! 👋


## Optimizations

# refactors,
# performance 
#improvements, 
#accessibility







## Demo

Insert gif or link to demo


## Documentation

[Documentation](https://githubtrendingapi.docs.apiary.io/#%23)


## Deployment

To deploy this project run

```bash
  npm run deploy
```



