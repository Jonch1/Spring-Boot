import {Component, OnInit} from '@angular/core';
import {Book} from '../../models/book';
import {BookServiceService} from '../../services/book-service.service';

@Component({
  selector: 'app-book-list',
  standalone: false,

  templateUrl: './book-list.component.html',
  styleUrl: './book-list.component.css'
})
export class BookListComponent implements OnInit {

  books?: Book[];

  constructor(private bookService: BookServiceService) {
  }

  ngOnInit() {
    this.fetchBooks()
  }

  private fetchBooks() {
    this.bookService.findAll().subscribe({
      next: value => {
        this.books = value;
        console.log(value)
      },
      error: error => {console.log(error)}
    })

  }
}
