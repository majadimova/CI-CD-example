Feature: Unos datuma rodjenja korisnika i izracunavanje starosti u danima
  Kao korisnik program
  Zelim da unesem datum rodjenja
  Da bi sistem proverio validnost datuma i izracunao starost u danima.

  Scenario Outline: Provera unosa datuma rodjenja i racunanje starosti u danima
    Given  korisnik unese datum rodjenja "<datumRodjenja>"
    When sistem proverava da li je datum ispravan i u proslosti
    Then prikazuje poruku "<poruka>"
    And izracunava broj dana proteklih od rodjenja "<brojDana>"

    Examples:
    | datumRodjenja | poruka                       | brojDana |
    | 15/06/1990    | Uspesan unos                 | 12400 |
    | 25/12/2025    | Greska:Datum je u buducnosti | 0 |
    | 30/02/2000    | Greska:Neispravan datum      | 0 |




