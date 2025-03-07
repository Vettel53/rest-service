# Bear Photo API (WIP)
Paws-itively spreading the beauty of bears! 

Currently hosted on https://randombear.onrender.com (Not Online Currently!!!)

## Overview
This project is heavily inspired by [random.dog](https://random.dog), [random-d.uk](https://random-d.uk), and [random.cat](https://random.cat). It's a RESTful service built with Spring Boot that fetches and displays random bear photos. Users can visit the website to load a random bear photo along with credits to the photographer.

## Features
- Fetch a random bear photo
- Display photographer credit for each photo
- Public API with multiple endpoints
- Open source

## Endpoints
### BASE URL `https://randombear.onrender.com`

### GET `/rawr`
Fetches a random bear photo URL and the photographer's name in JSON format.

### GET `/floofs`
Fetches all the bear photos with respective credit to photographer in JSON format.

### GET `/floofs-count`
Fetches the amount of bear photos available in the application.

## Contributing
Contributions are welcome! Please open an issue or submit a pull request for any changes
