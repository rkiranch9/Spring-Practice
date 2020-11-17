# Spring-Practice
Contains Examples of Implementing Micro-Services with SpringBoot

REST call --->  BusSearchService ---> FareService

Endpoints enabled for BusSearchService:
http://<IP>:8080/bussearch           -- to search all bus routes available
http://<IP>:8080/bussearch/hyd/bza   -- to request bus types available along with fare details

Endpoints enabled for FareService:
http://<IP>:8080/getFares?bustype=garuda,super luxury&distance=350  -- to get FarePerSeat and busType information for given busTypes and distance
http://<IP>:8080/fares                                              -- GET and POST for getting and adding new fares
http://<IP>:8080/fares/{type}/{distance}                            -- to get FarePerSeat for the given busType and distance
