import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-firstnavbar',
  templateUrl: './firstnavbar.component.html',
  styleUrls: ['./firstnavbar.component.css']
})
export class FirstnavbarComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  ingresar()
  {
    this.router.navigateByUrl('/login');
  }
}
