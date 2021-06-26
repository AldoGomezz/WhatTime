import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {LoginComponent} from "../login/login.component";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void
  {}

  ingresar()
  {
    this.router.navigateByUrl('/login');
  }



}
